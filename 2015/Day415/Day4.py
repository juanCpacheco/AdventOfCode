import hashlib
#Day4 The Ideal Stocking Stuffer
#Busca el numero que al unirse con el input(input+num) genera un MD5 hash que en hexadecimal comienza por 5 ceros

input = "yzbqklnj"
i = 0
while True:
    hashmd5 = hashlib.md5()
    actual = input + str(i)
    hashmd5.update(actual.encode())
    hexadecimal = hashmd5.hexdigest()
    if(hexadecimal.startswith("00000")):
        print(i)
        break
    i += 1

