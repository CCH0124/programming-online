awk '
    {
        for(i=1; i<=NF; i++)
        {   
            if(mtr[i] == "")
            {
                mtr[i] = $i
            }
            else
            {
                mtr[i] = mtr[i]" "$i
            }
        }
    }
    END{
         for(i=1; i<=NF; i++)
         {
             print mtr[i]
         }
       }
    ' < file.txt
