## Scrap Box

### Class

```java
import mods.ic2.ScrapBox;
```

### Methods

#### `addDrop(WeightedItemStack)`

```java
/*
 * Arguments: weightedItem
 *   - WeightedItemStack weightedItem The new entry of scrap box drop pool. Percentage weight will be divided by 100.
 */
ScrapBox.addDrop(<minecraft:diamond_ore>.weight(0.1));
ScrapBox.addDrop(<minecraft:diamond_ore> % 10); // Same as above, 10% == 0.1
```

#### `addDrop(IItemStack, float)`

```java
/*
 * Arguments: weightedItem, weight
 *   - WeightedItemStack weightedItem The new entry of scrap box drop pool. Percentage weight will be divided by 100.
 *   - float weight                   The weight of this new entry
 */
ScrapBox.addDrop(<minecraft:diamond_ore>, 0.1F); // Same as ScrapBox.addDrop(<minecraft:diamond_ore>.weight(0.1));
```