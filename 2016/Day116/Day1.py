#Day1 No Time for a Taxicab

#Se desea conocer la distancia a la que termina respento al punto inicial (0,0) al seguir las instrucciones donde R y L son giros de 90° y el numero son los pasos que da en esta direccion
#Para calcular la distancia se utilizo la geometria del taxista
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day116\\input.txt')
info = archivo.read()
direcciones = [0,0,0,0]
direccion = 0
for instruccion in info.split(', '):
    if instruccion[0] == 'R':
        direccion += 1
    else: 
        direccion -= 1
    direccion %= 4
    direcciones[direccion] += int(instruccion[1:])
x = direcciones[1]-direcciones[3]
y = direcciones[0]-direcciones[2]
print(abs(x)+abs(y))
archivo.close()


#Se desea saber a que distancia segun la geometria del taxista se encuentra el primer punto por el cual pasa dos veces
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day116\\input.txt')
info = archivo.read()
direcciones = [0,0,0,0]
direccion = 0
visitados = set()
visitados.add((0,0))
encontro = False
for instruccion in info.split(', '):
    if instruccion[0] == 'R':
        direccion += 1
    else: 
        direccion -= 1
    direccion %= 4
    for i in range(int(instruccion[1:])):
        direcciones[direccion] += 1
        x = direcciones[1]-direcciones[3]
        y = direcciones[0]-direcciones[2]
        if (x,y) in visitados:
            print(abs(x)+abs(y))
            encontro = True
            break
        visitados.add((x,y))
    if encontro: break
archivo.close()