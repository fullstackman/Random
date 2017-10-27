# Terminals
Settings and other stuff that will enhance my work on the commandline/terminal.

## UNIX-like
Copy and paste this into your `.bash_profile` in the root directory:
```
reset=$(tput sgr0)
redColor=$(tput setaf 1)
cyanColor=$(tput setaf 6)
greenColor=$(tput setaf 2)
export PS1='\[$redColor\]\@ \[$cyanColor\]\u\[$greenColor\]@\H\[$reset\]:\$ '
export PS2=' | | '
export CLICOLOR=1
export LSCOLORS=ExFxBxDxCxegedabagacad
alias ls='ls -GFh'
alias diskspace='du -a ~ | sort -rn | head -30'
```
