package org.agera.items.actionItemsApi.sql;

public class StatsTableEntity {
    private final String PlayerUUID;
    private final int droppedActionItem;
    private final int craftedActionItem;
    private final int collectedActionItem;
    private final int burningActionItem;
    private final String playerDisplayName;

    public StatsTableEntity(String playerDisplayName, String PlayerUUID, int droppedActionItem, int craftedActionItem, int collectedActionItem, int burningActionItem) {

        this.playerDisplayName = playerDisplayName;
        this.PlayerUUID = PlayerUUID;
        this.droppedActionItem = droppedActionItem;
        this.craftedActionItem = craftedActionItem;
        this.collectedActionItem = collectedActionItem;
        this.burningActionItem = burningActionItem;
    }


    public String getPlayerUUID() {
        return PlayerUUID;
    }

    public int getDroppedActionItem() {
        return droppedActionItem;
    }

    public int getCraftedActionItem() {
        return craftedActionItem;
    }

    public int getCollectedActionItem() {
        return collectedActionItem;
    }

    public int getBurningActionItem() {
        return burningActionItem;
    }

    public String getPlayerDisplayName() {
        return playerDisplayName;
    }

}
