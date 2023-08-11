for file in $(find . -type f -name "p*.c") 
do 
    fileName=`echo $file | cut -d'/' -f2 | cut -d'.' -f1`
    gcc -o $fileName $file 2>/dev/null
    if [ -f $fileName ] 
    then 
        ans=$(./$fileName)
        if [ $ans = 20 ]
        then
            ans=10
        else
            ans=7
        fi
    else 
        ans=5
    fi
    printf "%s %s\n" $fileName.c    $ans
done
