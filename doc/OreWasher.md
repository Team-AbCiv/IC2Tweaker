## Ore Washer

### Class

```java
import mods.ic2.OreWasher;
```

### Method

```java
/*
 * Arguments: outputs, input, hardness
 *   - IItemStack[] outputs
 *   - IIngredient input
 *   - @Optional int water  Amount of water required for one round of processing of this recipe,
 *                          measured in mB. Default to 1000 if not given.
 */
OreWasher.addRecipe([<minecraft:diamond>, <minecraft:emerald>, <minecraft:nether_star>], <minecraft:dirt>);
OreWasher.addRecipe([<minecraft:diamond>, <minecraft:emerald>, <minecraft:nether_star>], <minecraft:dirt>, 500);
```

This is equivalent to add the following line to `config/ic2/ore_washer.ini`:

```ini
minecraft:dirt = minecraft:diamond mincraft:emerald minecraft:nether_star @fluid:500
```

When using IC2 Experimental, to remove an existed recipe simply remove the corresponding line in `config/ic2/ore_washer.ini`.

When using IC2 Classic & Ic2c Extras, to remove an existed recipe simply disable the corresponding recipe in `config/ic2/ic2machineRecipes.json`.