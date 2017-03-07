#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Mar  3 15:57:51 2017

@author: Ziyan
"""
from numpy import loadtxt
from glob import glob
import os
import numpy as np
import matplotlib.pyplot as plt


fileNames = glob('./out/Solution*.dat')
fileNames.sort()
#print(fileNames)
for fileName in fileNames:
    fig = plt.figure()
    ax = fig.add_subplot(111)  
    f = open(fileName,'r')
    xCells = int(f.readline().strip().split(':')[1])
    yCells = int(f.readline().strip().split(':')[1])
    numGhostCells = int(f.readline().strip().split(':')[1])
    time = float(f.readline().strip().split(':')[1])
    f.close()

    x,y, u = loadtxt(fileName, skiprows = 4, unpack = True) 
    x = np.reshape(x, (xCells + 2*numGhostCells, yCells + 2*numGhostCells))
    y = np.reshape(y, (xCells + 2*numGhostCells, yCells + 2*numGhostCells))
    u = np.reshape(u, (xCells + 2*numGhostCells, yCells + 2*numGhostCells))
    plt.contourf(x,y,u)
    plt.colorbar()
    ax.set_title('%5.3f'%time)
    fig.savefig(fileName.replace('.dat','.png'))
    
os.system('eog'+ fileNames[0].replace('.dat','.png'))