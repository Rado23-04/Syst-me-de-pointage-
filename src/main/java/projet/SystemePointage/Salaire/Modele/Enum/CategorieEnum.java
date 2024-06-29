package projet.SystemePointage.Salaire.Modele.Enum;

public enum CategorieEnum {
    SUPERIOR_FRAME,
    NORMAL,
    GUARDIAN(true),
    DRIVER;
    private boolean worksAtNight;
    CategorieEnum() {
        this.worksAtNight = false;
    }
    CategorieEnum(boolean worksAtNight) {
        this.worksAtNight = worksAtNight;
    }
    public boolean isWorksAtNight() {
        return worksAtNight;
    }
}
//CategorieEnum DAY_GUARDIAN = new CategorieEnum(false);