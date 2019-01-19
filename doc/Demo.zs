/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

import mods.ic2.BlastFurnace;
import mods.ic2.BlockCutter;
import mods.ic2.Canner;
import mods.ic2.Compressor;
import mods.ic2.Electrolyzer;
import mods.ic2.Extractor;
import mods.ic2.Fermenter;
import mods.ic2.HeatExchanger;
import mods.ic2.Macerator;
import mods.ic2.MetalFormer;
import mods.ic2.OreWasher;
import mods.ic2.Recycler;
import mods.ic2.ScrapBox;
import mods.ic2.SemiFluidGenerator;
import mods.ic2.ThermalCentrifuge;

/*
 * Arguments: outputs, input, totalFluidCost, time
 *   - IItemStack[] outputs
 *   - IIngredient input
 *   - int totalFluidCost   Total fluid (IC2 liquefied air) cost, measured in mB
 *   - int time             Total time cost, measured in ticks
 */
BlastFurnace.addRecipe([<item:minecraft:diamond>, <item:minecraft:emerald>], <item:minecraft:dirt> * 64, 1000, 100);

/*
 * Arguments: output, input, hardness
 *   - IItemStack output
 *   - IIngredient input
 *   - @Optional int hardness Minimum hardness requirement for blade.
 *                            For reference, iron blade is 3; steel blade is 6; diamond blade is 9.
 *                            Default to 0 if not given.
 */
BlockCutter.addRecipe(<item:minecraft:diamond>, <item:minecraft:dirt>);
BlockCutter.addRecipe(<item:minecraft:diamond>, <item:minecraft:dirt>, 9);

/*
 * Arguments: output, container, filler
 *   - IItemStack output      The product
 *   - IIngredient container  The ingredient to be "filled"
 *   - IIngredient filler     The ingredient with which is filled into the container
 */
Canner.addBottleRecipe(<item:minecraft:diamond>, <item:minecraft:glass>, <item:minecraft:dirt>);
/*
 * Arguments: output, container, filler
 *   - ILiquidStack output    The product
 *   - ILiquidStack input     The base fluid ingredient
 *   - IIngredient additive   The solid ingredient to be mixed with
 */
Canner.addEnrichRecipe(<liquid:lava> * 1000, <liquid:water> * 1000, <item:minecraft:redstone>);

/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
Compressor.addRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64);

/*
 * Arguments: outputs, input, power, time
 *   - ILiquidStack[] outputs Array of all outputs. Each slot corresponds to Down-Up-North-South-West-East direction.
 *                            Tailing null may be omitted.
 *   - ILiquidStack input     The input
 *   - int power              Power consumption, measured in EU/tick
 *   - @Optional int time     Time cost. Default to 200 if not given.
 */
Electrolyzer.addRecipe([<liquid:lava> * 1000, <liquid:water> * 500], <liquid:water> * 1000, 30);
Electrolyzer.addRecipe([<liquid:lava> * 1000, <liquid:water> * 500, null, null, null, null], <liquid:water> * 1000, 30);
Electrolyzer.addRecipe([<liquid:lava> * 1000, <liquid:water> * 500, null, null, null, null], <liquid:water> * 1000, 30, 200);

/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
Extractor.addRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64);

/*
 * Arguments: output, input, heat
 *   - ILiquidStack output The fermented fluid
 *   - ILiquidStack input  The input fluid
 *   - int heat            The amount of heat required for fermentation
 */
Fermenter.addRecipe(<liquid:lava> * 1000, <liquid:water> * 2000, 23333);

HeatExchanger.addFluidCoolDown(<liquid:lava>, <liquid:water>, 10);
HeatExchanger.addFluidCoolDown(<liquid:lava>.definition, <liquid:water>.definition, 10); // Same as above
HeatExchanger.addFluidHeatUp(<liquid:lava>, <liquid:water>, 10);
HeatExchanger.addFluidHeatUp(<liquid:lava>.definition, <liquid:water>.definition, 10); // Same as above

/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
Macerator.addRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64);

/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
MetalFormer.addCuttingRecipe(<minecraft:diamond>, <minecraft:dirt> * 64);
/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
MetalFormer.addExtrudingRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64);
/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
MetalFormer.addRollingRecipe(<minecraft:diamond>, <minecraft:dirt> * 64);

/*
 * Arguments: outputs, input, hardness
 *   - IItemStack[] outputs
 *   - IIngredient input
 *   - @Optional int water  Amount of water required for one round of processing of this recipe,
 *                          measured in mB. Default to 1000 if not given.
 */
OreWasher.addRecipe([<minecraft:diamond>, <minecraft:emerald>, <minecraft:nether_star>], <minecraft:dirt>);
OreWasher.addRecipe([<minecraft:diamond>, <minecraft:emerald>, <minecraft:nether_star>], <minecraft:dirt>, 500);

/*
 * Arguments: ingredient
 *   - IIngredient ingredient The item to be blacklisted from recycler (as source of scrap)
 */
Recycler.addBlacklist(<minecraft:dirt>);
Recycler.addBlacklist(<ore:gemDiamond>);

/*
 * Arguments: weightedItem
 *   - WeightedItemStack weightedItem The new entry of scrap box drop pool. Percentage weight will be divided by 100.
 */
ScrapBox.addDrop(<minecraft:diamond_ore>.weight(0.1));
ScrapBox.addDrop(<minecraft:diamond_ore> % 10); // Same as above, 10% == 0.1
/*
 * Arguments: weightedItem, weight
 *   - WeightedItemStack weightedItem The new entry of scrap box drop pool. Percentage weight will be divided by 100.
 *   - float weight                   The weight of this new entry
 */
ScrapBox.addDrop(<minecraft:diamond_ore>, 0.1F); // Same as above

/*
 * Arguments: liquid, powerOutput
 *   - ILiquidStack liquid The liquid which can be used as fuel in semi-fluid generator
 *   - double powerOutput  The power output, measured in EU/tick
 */
SemiFluidGenerator.addFluid(<liquid:water>, 2333.0D);

/*
 * Arguments: outputs, input, minHeat
 *   - IItemStack[] outputs
 *   - IIngredient input
 *   - @Optional int minHeat Minimum heat requirement for the thermal centrifuge before it starts to process
 *                           this recipe. Default to 1000 if not given.
 */
ThermalCentrifuge.addRecipe([<minecraft:diamond>, <minecraft:emerald>, <minecraft:nether_star>], <minecraft:dirt>);
ThermalCentrifuge.addRecipe([<minecraft:diamond>, <minecraft:emerald>, <minecraft:nether_star>], <minecraft:dirt>, 500);
