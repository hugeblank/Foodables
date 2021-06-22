package truth.foodables.blocks.blockentityrenderers;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;
import truth.foodables.blocks.JungleDryingRack;
import truth.foodables.blocks.blockentities.JungleDryingRackEntity;

@Environment(EnvType.CLIENT)
public class JungleDryingRackRenderer implements BlockEntityRenderer<JungleDryingRackEntity> {

    public JungleDryingRackRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(JungleDryingRackEntity entity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack itemStack = entity.getStack(0);
        Direction dir = (Direction)entity.getCachedState().get(JungleDryingRack.FACING);
        int k = (int)entity.getPos().asLong();

        if (!itemStack.isEmpty()) {
            matrixStack.push();
            switch(dir) {
                case NORTH:
                    matrixStack.translate(0.5F, 0.3125F, 0.96875F);
                    break;
                case SOUTH:
                    matrixStack.translate(0.5F, 0.3125F, 0.03125F);
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180F));
                    break;
                case EAST:
                    matrixStack.translate(0.03125F, 0.3125F, 0.5F);
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(270F));
                    break;
                case WEST:
                    matrixStack.translate(0.96875F, 0.3125F, 0.5F);
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90F));
                    break;
                default:
                    
            }
            itemRenderer.renderItem(itemStack, ModelTransformation.Mode.FIXED, light, overlay, matrixStack, vertexConsumers, k);
            matrixStack.pop();
        }

    }
    
}
