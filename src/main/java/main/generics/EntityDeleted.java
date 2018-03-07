package main.generics;

public final class EntityDeleted {
    private final boolean deleted;

    public EntityDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
