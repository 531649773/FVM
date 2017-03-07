#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Mar  3 15:57:51 2017

@author: Ziyan
"""
from numpy import loadtxt
from pylab import figure, ioff
from glob import glob
import os

ioff()

fileNames = glob('./out/Solution*.dat')
fileNames.sort()
#print(fileNames)
for fileName in fileNames:
    fig = figure()
    ax = fig.add_subplot(111)  
    f = open(fileName,'r')
    xCells = int(f.readline().strip().split(':')[1])
    numGhostCells = int(f.readline().strip().split(':')[1])
    time = float(f.readline().strip().split(':')[1])
    f.close()

    x,u = loadtxt(fileName, skiprows = 3, unpack = True) 
    p, = ax.plot(x,u,lw = 5)
    ax.set_xlim(-1,1)
    ax.set_ylim(-0.1,1.1)
    ax.set_title('%5.3f'%time)
    fig.savefig(fileName.replace('.dat','.png'))
    
os.system('eog'+ fileNames[0].replace('.dat','.png'))