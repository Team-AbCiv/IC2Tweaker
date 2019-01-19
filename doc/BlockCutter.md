## Block Cutter

### Class

```java
import mods.ic2.BlockCutter
```

### Method

```java
/*
 * Arguments: output, input, hardness
 *   - IItemStack output
 *   - IIngredient input
 *   - @Optional int hardness Minimum hardness requirement for blade.
 *                            For reference, iron blade is 3; steel blade is 6; diamond blade is 9.
 *                            Default to 0 if not given.
 */
BlockCutter.addRecipe(<item:minecraft:diamond>, <item:minecraft:dirt>); // Hardness requirement defaults to 0
BlockCutter.addRecipe(<item:minecraft:diamond>, <item:minecraft:dirt>, 9);
```

This is equivalent to add the following line to `config/ic2/block_cutter.ini`:

```ini
minecraft:dirt = minecraft:diamond @hardness:9
```

To remove an existed recipe, simply remove the corresponding line in `config/ic2/block_cutter.ini`.