import random
import requests
import json
from datetime import datetime


# 若依后端地址（根据实际环境调整）
RUOYI_BACKEND = "http://localhost:8080"


def get_jwt_token(username, password):
    """获取若依JWT令牌（需具有detector:traffic:add权限的用户）"""
    login_url = f"{RUOYI_BACKEND}/login"
    payload = {
        "username": username,
        "password": password,
        "code": "",  # 去掉了
        "uuid": ""
    }
    response = requests.post(login_url, json=payload)
    return response.json().get("token")


def detect_malicious_traffic():
    """模拟恶意流量检测逻辑（实际需替换为真实检测算法）"""
    # 示例检测结果（源IP、目标IP、时间、威胁等级）
    random_number = random.choice([0, 1, 2])
    return {
        "sourceIp": "192.168.1.100",
        "destinationIp": "10.0.0.5",
        "trafficTime": datetime.now().strftime("%Y-%m-%d")  ,  # 时间格式需与后端匹配
        "threatLevel": random_number
    }


def report_to_ruoyi(token, traffic_data):
    """调用若依API上报恶意流量数据"""
    headers = {
        "Authorization": f"Bearer {token}",
        "Content-Type": "application/json"
    }
    add_url = f"{RUOYI_BACKEND}/detector/traffic"
    response = requests.post(add_url, headers=headers, json=traffic_data)
    if response.status_code == 200:
        print("数据上报成功")
    else:
        print(f"数据上报失败：{response.text}")


if __name__ == "__main__":
    # 1. 获取认证令牌（使用具有添加权限的用户）
    token = get_jwt_token("admin", "admin123")  # 替换为实际账号密码

    # 2. 模拟检测恶意流量
    malicious_traffic = detect_malicious_traffic()

    # 3. 上报数据到若依
    report_to_ruoyi(token, malicious_traffic)