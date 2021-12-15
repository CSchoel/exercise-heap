import numpy as np

def create_arrays():
  return np.arange(1, 4), np.arange(4, 7)

def crossp(v1, v2):
    return np.cross(v1, v2)

def dist(v1, v2):
    return  np.sqrt(np.sum((v1 - v2) ** 2)) #np.linalg.norm(v1 - v2)

