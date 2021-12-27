
def getName():
    respuesta = 'siguiente'
    return respuesta

print("Hello world")
print(getName())

luces = [[0]*1000 for i in range(1000)]
for fila in range(0, 5):
        for luz in luces[fila][0:5]:
            print(luz)
