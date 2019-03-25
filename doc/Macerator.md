## Macerator

### Class

```java
import mods.ic2.Macerator;
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

In IC2 Experimental, this is equivalent to add the following line to `config/ic2/macerator.ini`:

```ini
minecraft:dirt*64 = minecraft:diamond_block
```

In IC2 Classic, this is equivalent to add the following line to `config/ic2/customMachineRecipes.json`:
```json
        {
			"recipeType": "macerator",
			"outputs":
			[
				{
					"item": "minecraft:diamond_block",
					"meta": 0,
					"amount": 1
				}
			],
			"input":
			{
				"inputType": "item",
				"item": "minecraft:dirt",
				"meta": 0,
                "amount": 64
			}
		}
```

When using IC2 Experimental, to remove an existed recipe simply remove the corresponding line in `config/ic2/macerator.ini`.

When using IC2 Classic, to remove an existed recipe simply disable the corresponding recipe in `config/ic2/ic2machineRecipes.json`.