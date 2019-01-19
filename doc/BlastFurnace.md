## Blast Furnace

### Class

```java
import mods.ic2.BlastFurnace;
```

### Methods

```java
/*
 * Arguments: outputs, input, fluidCost, time
 *   - IItemStack[] outputs
 *   - IIngredient input
 *   - int totalFluidCost   Per-tick IC2 liquefied air cost, measured in mB/tick
 *   - int time             Total time cost, measured in ticks
 */
BlastFurnace.addRecipe([<item:minecraft:diamond>, <item:minecraft:emerald>], <item:minecraft:dirt> * 64, 1, 1000);
```

This is equivalent to add the following line to `config/ic2/blast_furnace.ini`:

```ini
minecraft:dirt*64 = minecraft:diamond minecraft:emerald @fluid:1 @duration:1000
```

To remove an existed recipe, simply remove the corresponding line in `config/ic2/blast_furnace.ini`.