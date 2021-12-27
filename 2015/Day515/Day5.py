#Day5 Doesn't He Have Intern-Elves For This?

#Imprime el numero de cadenas que cumplen con las condiciones 1,2 y 3
def puzzle1(linea):
    if len(list(filter(lambda x: x in 'aeiou', linea))) < 3:
        return False
    for x,y in zip(linea, linea[1:]):
        if x == y:
            for pareja in ['ab', 'cd', 'pq', 'xy']:
                if pareja in linea:
                    return False
            return True            
    return False

#Imprime el numero de cadenas que cumplen con las condiciones 4 y 5
def puzzle2(linea):
    for x,y in zip(linea, linea[2:]):
        if x == y:
            for i in range(len(linea)-2):
                pareja = linea[i] + linea[i+1]
                for j in range(i+2, len(linea)-1):
                    pareja2 = linea[j] + linea[j+1]
                    if pareja == pareja2:
                        return True
            return False
    return False

archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day515\\input.txt')
contador = 0
for linea in archivo:
    if puzzle1(linea.rstrip('\n')):
        contador += 1
print(contador)
archivo.close()

archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day515\\input.txt')
contador = 0
for linea in archivo:
    if puzzle2(linea.rstrip('\n')):
        contador += 1
print(contador)
archivo.close()