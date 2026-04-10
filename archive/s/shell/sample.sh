#!/bin/bash
# A shell script with shellcheck issues

# SC2086: unquoted variable
echo $name

# SC2034: variable assigned but never used
unused_var="hello"
