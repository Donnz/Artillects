package artillects.hive.structure;

import artillects.hive.schematics.Schematic;

public enum EnumStructurePeaces
{
    TEST("", "[Laggy]Hive complex Test [A]"),
    TESTB("", "[Laggy]Fabricator Test [B]"),
    TUNNELZ("5x5ZTunnel"),
    TUNNELX("5x5XTunnel"),
    WALLZ("5x5ZWall"),
    WALLX("5x5XWall"),
    TUNNELC("5x5CTunnel"),
    FLOOR("5x5Floor"),
    SKYLIGHT("5x5Floor"),
    NODE("5x5TunnelNode"),
    PROCESSORROOM("processorBuilding", "Processor Room"),
    TELEFLOOR("teleFloor", "Teleport Pad"),
    COREFLOOR("coreFloor"),
    SMALL_ROOM("smallRoom");

    public String saveName, toolName;
    public Schematic schematic;
    public boolean makeTool = false;

    private EnumStructurePeaces(String name)
    {
        this.saveName = name;
    }

    private EnumStructurePeaces(String name, String toolName)
    {
        this(name);
        this.toolName = toolName;
        this.makeTool = true;
    }

    public Schematic getSchematic()
    {
        if (schematic == null)
        {
            schematic = new Schematic();
            schematic.getFromResourceFolder(saveName);
        }
        return schematic;
    }
}
