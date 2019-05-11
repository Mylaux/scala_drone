# -*- coding: UTF-8 -*-

import random
import shutil
import os

shutil.rmtree("jsons/")
os.mkdir("jsons/")

coordinates = ["N", "W", "E", "S"]
for i in range(50):
    file = open("jsons/test" + str(i) + ".txt", "w", encoding = "UTF-8")

    for j in range(random.randint(1, 15)):
        file.write("{")
        file.write("\"id\":" + str(random.randint(1,100)) + ",")
        file.write("\"latitude\":\"" + str(random.randint(0,90)) + "°" + str(random.randint(0,60)) + "\'" + str(random.randint(0,59)) + coordinates[random.randint(0,3)]+ "\",")
        file.write("\"longitude\":\"" + str(random.randint(0,90)) + "°" + str(random.randint(0,60)) + "\'" + str(random.randint(0,59)) + coordinates[random.randint(0,3)]+ "\",")
        file.write("\"temperature\":" + str(random.randint(0,50)) + ",")
        file.write("\"battery\":" + str(random.randint(0,100)) + ",")
        file.write("\"weight\":" + str(random.randint(1000,4000)))
        file.write("}\n")
    file.close()