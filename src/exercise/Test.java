package exercise;


import java.util.ArrayList;
import java.util.List;

// 定义用户接口状态
enum InterfaceStatus {
    NOT_OPENED, // 未开通
    OPENED, // 已开通
    STOPPED // 已停用
}

// 定义用户接口权限
class InterfacePermission {
    public InterfaceStatus status; // 权限状态
    public String userId; // 用户ID
    public String interfaceId; // 接口ID

    public InterfacePermission(String userId, String interfaceId) {
        this.userId = userId;
        this.interfaceId = interfaceId;
        this.status = InterfaceStatus.NOT_OPENED;
    }
}






