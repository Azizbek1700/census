package uz.bakhodirov.census.enums;

import lombok.Getter;

@Getter
public enum FamilyStatus {
    OILA_QURGAN,
    AJRASHGAN,
    BEVA;

    public FamilyStatus checkRole(String role) {
        for (FamilyStatus value : values()) {
            if (value.name().equalsIgnoreCase(role)) {
                return value;
            }
        }
        throw new RuntimeException("role not found");
    }
}
