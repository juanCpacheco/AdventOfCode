#Day2 I Was Told There Would Be No Math

#se desea el area total del papel de regalo que se necesita
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day215\\input.txt')
total = 0
for line in archivo.readlines():
    l,w,h = list(map(int, line.split('x')))
    area1,area2,area3 = l*w, l*h, w*h
    total  += 2*(area1 + area2 + area3) + min(area1,area2,area3)
archivo.close()
print("Area total: ", total)

#Se desea saber la longitud total de la cinta para los regalos
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day215\\input.txt')
total = 0
for line in archivo.readlines():
    dimensiones = list(map(int, line.split('x')))
    a,b,c = sorted(dimensiones)
    total += 2*(a+b) + a*b*c
archivo.close()
print("Cinta total: ", total)