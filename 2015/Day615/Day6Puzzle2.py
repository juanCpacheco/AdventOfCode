#Day6 Probably a Fire Hazard

#Se desea saber el brllo total al seguir las instrucciones del input (una luz tiene brillo de 0 en adelante)
#donde Turn on: aumenta el brillo en 1, Turn off: disminuye el brillo en 1 y Toogle: aumenta el brillo en 2.
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day615\\input.txt')
luces = [[0]*1000 for i in range(1000)]
brillo = 0
for line in archivo:
    line = line.rstrip()
    partes = line.split(' ')
    desde = [int(x) for x in partes[-3].split(',')]
    hasta = [int(x) for x in partes[-1].split(',')]
    instruccion =  ' '.join(partes[:-3])
    for fila in range(desde[0], hasta[0]+1):
        x,y = desde[1],hasta[1]+1
        if instruccion == "turn off":
            for luz in range(x,y): luces[fila][luz] = max(0, luces[fila][luz]-1)
        elif instruccion == "turn on":
            for luz in range(x,y): luces[fila][luz] += 1
        else:
            for luz in range(x,y): luces[fila][luz] += 2
archivo.close()
for fila in range(1000):
    for luz in luces[fila]:
        brillo += luz
print(brillo)
