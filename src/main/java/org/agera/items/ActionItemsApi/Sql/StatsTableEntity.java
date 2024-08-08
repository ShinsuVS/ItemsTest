package org.agera.items.ActionItemsApi.Sql;

public class StatsTableEntity {
    private String PlayerUUID;
    private int droppedActionItem;
    private int craftedActionItem;
    private int collectedActionItem;
    private int burningActionItem;
    private String playerDisplayName;

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
