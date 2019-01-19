## Macerator

### Class

```java
import mods.ic2.Macerator
```

### Method

```java
/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
Macerator.addRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64);
```

This is equivalent to add the following line to `config/ic2/macerator.ini`:

```ini
minecraft:dirt*64 = minecraft:diamond_block
```

To remove an existed recipe, simply remove the corresponding line in `config/ic2/macerator.ini`.