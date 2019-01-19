## Thermal Centrifuge

### Class

```java
import mods.ic2.ThermalCentrifuge;
```

### Method

```java
/*
 * Arguments: outputs, input, minHeat
 *   - IItemStack[] outputs
 *   - IIngredient input
 *   - @Optional int minHeat Minimum heat requirement for the thermal centrifuge before it starts to process
 *                           this recipe. Default to 1000 if not given.
 */
ThermalCentrifuge.addRecipe([<minecraft:diamond>, <minecraft:emerald>, <minecraft:nether_star>], <minecraft:dirt>);
ThermalCentrifuge.addRecipe([<minecraft:diamond>, <minecraft:emerald>, <minecraft:nether_star>], <minecraft:dirt>, 500);
```

This is equivalent to add the following line to `config/ic2/thermal_centrifuge.ini`:

```ini
minecraft:dirt = minecraft:diamond mincraft:emerald minecraft:nether_star @heat:500
```

To remove an existed recipe, simply remove the corresponding line in `config/ic2/thermal_centrifuge.ini`.
