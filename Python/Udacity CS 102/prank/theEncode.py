import os
import random

# I had to create this program myself to make it possible to encode all
# of the example file names so that the decode program can be run again!
# Obviously, this borrow heavily from decode.py
# the naming convention keeps this file from interrupting the order of
# the files that spell out the secret message

def rename_files():
	file_list = os.listdir(r"PATH TO THE PRANK FOLDER")
	original_path = os.getcwd()
	print(original_path)
	os.chdir(r"PATH TO THE PRANK FOLDER")
	for file_name in file_list:
		if ".py" not in file_name:
			# append a random integer (from 0 to 9) to the file name
			# this is good enough to completely mess up the true order
			# of the secret message!
			temp_string = str(random.randrange(10)) + file_name
			# testing the output
			#print(temp_string)
			os.rename(file_name, temp_string)
	os.chdir(original_path)

#Main Method
rename_files()
