## Canner

### Class

```java
import mods.ic2.Canner;
```

### Methods

#### `addBottleRecipe`

```java
/*
 * Arguments: output, container, filler
 *   - IItemStack output      The product
 *   - IIngredient container  The ingredient to be "filled"
 *   - IIngredient filler     The ingredient with which is filled into the container
 */
Canner.addBottleRecipe(<item:minecraft:diamond>, <item:minecraft:glass>, <item:minecraft:dirt>);
```

#### `addEnrichRecipe`

```java
/*
 * Arguments: output, container, filler
 *   - ILiquidStack output    The product
 *   - ILiquidStack input     The base fluid ingredient
 *   - IIngredient additive   The solid ingredient to be mixed with
 */
Canner.addEnrichRecipe(<liquid:lava> * 1000, <liquid:water> * 1000, <item:minecraft:redstone>);
```