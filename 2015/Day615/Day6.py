#Day6 Probably a Fire Hazard

#//Se desea saber cuantas luces quedaron encendidas al seguir las instrucciones del input
#donde Turn on: encender, Turn off: apagar y Toogle: enciende apagadas y apaga encendidas.
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day615\\input.txt')
luces = [[False]*1000 for i in range(1000)]
encendidas = 0
for line in archivo:
    line = line.rstrip()
    partes = line.split(' ')
    desde = [int(x) for x in partes[-3].split(',')]
    hasta = [int(x) for x in partes[-1].split(',')]
    instruccion =  ' '.join(partes[:-3])
    for fila in range(desde[0], hasta[0]+1):
        x,y = desde[1],hasta[1]+1
        if instruccion == "turn off":
            luces[fila][x:y] = [False]*abs(y-x)
        elif instruccion == "turn on":
            luces[fila][x:y] = [True]*abs(y-x)
        else:
            luces[fila][x:y] = [not x for x in luces[fila][x:y]]
archivo.close()
for fila in range(1000):
    for luz in luces[fila]:
        if luz:
            encendidas += 1
print(encendidas)
