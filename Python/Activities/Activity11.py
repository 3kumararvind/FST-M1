fruit = {
    "mango":20,
    "guava":10,
    "grapes":90
}
fruit_name = input("Enter fruit name to check:").lower()

if fruit_name in fruit.keys():
    print("Fruit available in shop.")
else:
    print("Fruit not available in shop.")