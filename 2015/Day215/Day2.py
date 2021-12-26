#Day2 I Was Told There Would Be No Math

#se desea el area total del papel de regalo que se necesita
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day215\\input.txt')
total = 0
for line in archivo.readlines():
    dimensiones = line.split('x')
    dimensiones = list(map(int, dimensiones))
    areas = dimensiones[0]*dimensiones[1], dimensiones[0]*dimensiones[2], dimensiones[1]*dimensiones[2]
    principal = 2*(areas[0] + areas[1] + areas[2])
    total  += principal + min(areas)
archivo.close()
print("Area total: ", total)

#Se desea saber la longitud total de la cinta para los regalos
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day215\\input.txt')
total = 0
for line in archivo.readlines():
    dimensiones = line.split('x')
    dimensiones = list(map(int, dimensiones))
    dimensiones.sort()
    inicial = 2*(dimensiones[0] + dimensiones[1])
    plus = dimensiones[0] * dimensiones[1] * dimensiones[2]
    total += inicial + plus
archivo.close()
print("Cinta total: ", total)