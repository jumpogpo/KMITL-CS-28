import numpy as np

u = np.array([2, -5, 7])  # โจทย์กำหนดให้ u = 2i - 5j + 7k
v = np.array([-1, 4, -3])  # โจทย์กำหนดให้ v = -i + 4j - 3k
w = np.array([5, 2, 4])  # คิดขึ้นเอง

print(f"[a] u + v: { u + v }")
print(f"[b] u * v: { u * v }")
print(f"[c] u.v: { np.dot(u, v) }")
print(f"[d] u x v: { np.cross(u, v) }")
print(f"[e] (u + v).u: { np.dot(u + v, u) }")
print(f"[f] (u - v) x v: { np.cross(u - v, v) }")
print(f"[g] v - u / √ u.u: { (v - u) / np.linalg.norm(np.dot(u, u)) }")
print(f"[h] (u.v / v.v) * w: { (np.dot(u, v) / np.dot(v, v)) * w }")
