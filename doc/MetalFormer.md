## Metal Former

### Class

```java
import mods.ic2.MetalFormer
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

To remove an existed recipe, simply remove the corresponding line in `config/ic2/metal_former_cutting.ini`.

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

To remove an existed recipe, simply remove the corresponding line in `config/ic2/metal_former_extruding.ini`.

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

To remove an existed recipe, simply remove the corresponding line in `config/ic2/metal_former_rolling.ini`.