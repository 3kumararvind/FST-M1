import pandas

dataframe = pandas.read_excel('sampleFile.xlsx')
print(dataframe)
print("====================================")
print("Number of rows and columns:", dataframe.shape)
print("Printed Emails:")
print(dataframe['Email'])

print("Sorted First Name:")
print(dataframe.sort_values('FirstName'))