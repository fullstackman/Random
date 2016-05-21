import os

# This program will read in the files of a given directory and remove the
# encoding from their names. When used on the given sample images, the
# resulting order of the images spells out a secret message!

def rename_files():
	# listdir will fetch all of the files in the directory that the prank
	# folder points to.
	file_list = os.listdir(r"PATH TO THE PRANK FOLDER")
	# the "Get Current Working Directory" (getcwd) method will fetch the
	# current directory for us
	original_path = os.getcwd()
	
	# testing the assignment
	# print(original_path)
	
	# now it's time to get to work. The "Change Directory" (chdir) method
	# will take us to the prank folder so that we can perform all of the
	# necessary operations.
	os.chdir(r"PATH TO THE PRANK FOLDER")
	
	# just loop through each file
	for file_name in file_list:
		# had to add this check on my own because the instructor failed to
		# mention that this program will read in its own filename!
		# we are only interested in the photo files
		if ".py" not in file_name:
			# the strip method will remove the specified characters from the
			# string of the file name. We target digits because those were used
			# as the basis of the encoding
			os.rename(file_name, file_name.strip("0123456789"))
	# we return to the original working directory (where we executed this program
	# from) so that after execution of this method, we aren't stuck in the prank
	# folder and can't continue the program
	os.chdir(original_path)

#Main Method
rename_files()
