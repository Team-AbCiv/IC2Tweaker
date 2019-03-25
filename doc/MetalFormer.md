## Metal Former

### Class

```java
import mods.ic2.MetalFormer;
```

### Method

#### `addCuttingRecipe`

```java
/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
MetalFormer.addCuttingRecipe(<minecraft:diamond>, <minecraft:dirt> * 64);
```

This is equivalent to add the following line to `config/ic2/metal_former_cutting.ini`:

```ini
minecraft:dirt*64 = minecraft:diamond_block
```

When using IC2 Experimental, to remove an existed recipe simply remove the corresponding line in `config/ic2/metal_former_cutting.ini`.

When using IC2 Classic & Ic2 Classic Extras, to remove an existed recipe simply disable the corresponding recipe in `config/ic2/ic2machineRecipes.json`.

#### `addExtrudingRecipe`

```java
/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
MetalFormer.addExtrudingRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64);
```

This is equivalent to add the following line to `config/ic2/metal_former_extruding.ini`:

```ini
minecraft:dirt*64 = minecraft:diamond_block
```

When using IC2 Experimental, to remove an existed recipe simply remove the corresponding line in `config/ic2/metal_former_extruding.ini`.

When using IC2 Classic & Ic2 Classic Extras, to remove an existed recipe simply disable the corresponding recipe in `config/ic2/ic2machineRecipes.json`.

#### `addRollingRecipe`

```java
/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
MetalFormer.addRollingRecipe(<minecraft:diamond>, <minecraft:dirt> * 64);
```

This is equivalent to add the following line to `config/ic2/metal_former_rolling.ini`:

```ini
minecraft:dirt*64 = minecraft:diamond_block
```

When using IC2 Experimental, to remove an existed recipe simply remove the corresponding line in `config/ic2/metal_former_rolling.ini`.

When using IC2 Classic & Ic2 Classic Extras, to remove an existed recipe simply disable the corresponding recipe in `config/ic2/ic2machineRecipes.json`.