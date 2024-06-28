package ru.filden.amethystvoid.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.filden.amethystvoid.item.items;
import ru.filden.amethystvoid.screen.AVCleanerScreenHandler;

public class AmethystCleanerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory= DefaultedList.ofSize(2,ItemStack.EMPTY);
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress= 400;

    public AmethystCleanerBlockEntity(BlockPos pos, BlockState state) {
        super(AVBlockEntities.AMETHYST_CLEANER_BLOCK_ENTITY_TYPE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch(index){
                    case 0 -> AmethystCleanerBlockEntity.this.progress;
                    case 1 -> AmethystCleanerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch(index){
                case 0 -> AmethystCleanerBlockEntity.this.progress = value;
                case 1 -> AmethystCleanerBlockEntity.this.maxProgress = value;}
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }


    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.amethystvoid.amethyst_cleaner");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new AVCleanerScreenHandler(syncId, inv, this, this.propertyDelegate);

    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, AmethystCleanerBlockEntity entity) {
        if(world.isClient()) {
            return;
        }
        if(hasRecipe(entity)){
            entity.progress++;
            markDirty(world,blockPos,state);
            if(entity.progress>= entity.maxProgress){
                craftItem(entity);
            }
        }else{
            entity.resetProgress();
            markDirty(world,blockPos,state);
        }
    }

    private static boolean hasRecipe(AmethystCleanerBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i = 0;i< entity.size();i++){
            inventory.setStack(i,entity.getStack(i));
        }
        boolean hasAmethystInFSlot = entity.getStack(0).getItem()== Items.AMETHYST_SHARD;
        return  hasAmethystInFSlot && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, items.PURE_AMETHYST);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(1).getItem() == output || inventory.getStack(1).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(1).getMaxCount() > inventory.getStack(1).getCount();
    }
    private static void craftItem(AmethystCleanerBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        if(hasRecipe(entity)) {
            entity.removeStack(0, 1);

            entity.setStack(1, new ItemStack(items.PURE_AMETHYST,
                    entity.getStack(1).getCount() + 1));

            entity.resetProgress();
        }
    }
    private void resetProgress() {
        this.progress = 0;
    }

    @Override
    protected void writeNbt(NbtCompound nbt){
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("amethyst_cleaner.progress", progress);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("amethyst_cleaner.progress");
    }

}
