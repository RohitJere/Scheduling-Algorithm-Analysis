package sample;

import java.util.concurrent.TimeUnit;

public class Scheduling {

    double FCFS(int bt[], int size)
    {
        int wt[] = new int[99999];
        int tat[] = new int[99999];
        wt[0] = 0;
        for(int i=1;i<=size;i++ ) {
            wt[i] = wt[i-1] + bt[i-1];
        }
        for(int i  =0;i<size;i++) {
            tat[i] = wt[i] + bt[i];
        }
        float awt=0;
        for(int i  =0;i<size;i++) {
            awt+=wt[i];
        }

        float atat=0;
        for(int i  =0;i<size;i++) {
            atat+=tat[i];
        }

        awt = awt/size;
        atat = atat/size;
        return (awt+atat)/2;
    }


    public double SJF(int o[], int bt[], int size)
    {   int t1,t2;
        int wt[] = new int[99999];
        int tat[] = new int[99999];
        float awt=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size-i-1;j++)
            {
                if(bt[j]>bt[j+1])
                {
                    t1=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=t1;
                    t2=o[j];
                    o[j]=o[j+1];
                    o[j+1]=t2;
                }
            }
        }
        for(int i=1;i<=size;i++ ) {
            wt[i] = wt[i-1] + bt[i-1];
        }
        for(int i  =0;i<size;i++) {
            tat[i] = wt[i] + bt[i];
        }
        for(int i  =0;i<size;i++) {
            awt+=wt[i];
        }

        float atat=0;
        for(int i  =0;i<size;i++) {
            atat+=tat[i];
        }

        awt = awt/size;
        atat = atat/size;
        return (awt+atat)/2;
    }


    double Priority(int o[], int bt[], int size, int prio[])
    {
        int t1,t2,t3;
        int wt[] = new int[99999];
        int tat[] = new int[99999];
        float awt=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size-i-1;j++)
            {
                if(prio[j]>prio[j+1])
                {
                    t1=prio[j];
                    prio[j]=prio[j+1];
                    prio[j+1]=t1;
                    t2=o[j];
                    o[j]=o[j+1];
                    o[j+1]=t2;
                    t3=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=t3;
                }
            }
        }
        for(int i=1;i<=size;i++ ) {
            wt[i] = wt[i-1] + bt[i-1];
        }
        for(int i  =0;i<size;i++) {
            tat[i] = wt[i] + bt[i];
        }
        for(int i  =0;i<size;i++) {
            awt+=wt[i];
        }

        float atat=0;
        for(int i  =0;i<size;i++) {
            atat+=tat[i];
        }

        awt = awt/size;
        atat = atat/size;
        return (awt+atat)/2;
    }

    double RR(int bt[], int size)
    {   int ts,t=0;
        int rembt[] = new int[99999];
        int wt[] = new int[99999];
        int tat[] = new int[99999];
        ts=2;
        for(int i=0;i<size;i++)
        {	rembt[i]=bt[i];	}
        while(true)
        {
            boolean done=true;
            for (int i=0;i<size;i++)
            {
                if (rembt[i]>0)
                {
                    done=false;
                    if (rembt[i]>ts)
                    {
                        t=t+ts;
                        rembt[i]=rembt[i]-ts;
                    }
                    else
                    {
                        t=t+rembt[i];
                        wt[i]=t-bt[i];
                        rembt[i]=0;
                    }
                }
            }
            if(done==true)
            { break; }
        }
        for(int i=1;i<=size;i++ ) {
            wt[i] = wt[i-1] + bt[i-1];
        }
        for(int i  =0;i<size;i++) {
            tat[i] = wt[i] + bt[i];
        }
        float awt=0;
        for(int i  =0;i<size;i++) {
            awt+=wt[i];
        }

        float atat=0;
        for(int i  =0;i<size;i++) {
            atat+=tat[i];
        }

        awt = awt/size;
        atat = atat/size;
        return (awt+atat)/2;
    }


    double FCFSD(int t[],int n) {
        double total = 0;
        double avgt;
        for(int i=0;i<n;i++)
        {	total=total+Math.abs(t[i]-t[i+1]);	}
        System.out.println("Total no. of distance of tracks= "+total);
        avgt=total/n;
        return avgt;
    }

    double SSTF(int t[],int n) {
        double total = 0;
        int temp;
        double avgt;
        for(int i=0;i<n;i++)
        {	for(int j=i+1;j<=n;j++)
        {	if(Math.abs(t[i]-t[i+1])>Math.abs(t[i]-t[j]))
        {	temp=t[j];
            t[j]=t[i+1];
            t[i+1]=temp;	}
        }
        }
        for(int i=0;i<n;i++)
        {	total=total+Math.abs(t[i]-t[i+1]);	}
        System.out.println("Total no. of distance of tracks= "+total);
        avgt=total/n;
        return avgt;
    }

    double LOOK(int t[],int n) {
        int[] d=new int[99999];
        double total = 0;
        int temp,max,dloc=0,h = 0;
        double avgt;
        h=t[n] = 0;
        n=n+1;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(t[i]>t[j])
                {
                    temp=t[i];t[i]=t[j];t[j]=temp;
                }
            }
        }
        max=t[n];
        for(int i=0;i<n;i++)
        {
            if(h==t[i]){dloc=i;break;}
        }
        int j=0;
        for(int i=dloc;i>=0;i--)
        {
            d[j]=t[i];j++;
        }
        for(int i=dloc+1;i<n;i++)
        {
            d[j]=t[i];j++;
        }
        for(int i=0;i<n-1;i++)
        {	total=total+Math.abs(d[i]-d[i+1]);	}
        System.out.println("Total no. of distance of tracks= "+total);
        avgt=total/n;
        return avgt;
    }

    double CLOOK(int t[],int n) {
        int[] d=new int[99999];
        double total = 0;
        int temp,max,dloc=0,h = 0;
        double avgt;
        h=t[n] = 0;
        n=n+1;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(t[i]>t[j])
                {
                    temp=t[i];t[i]=t[j];t[j]=temp;
                }
            }
        }
        max=t[n];
        for(int i=0;i<n;i++)
        {
            if(h==t[i]){dloc=i;break;}
        }
        int j=0;
        for(int i=dloc;i>=0;i--)
        {
            d[j]=t[i];j++;
        }
        for(int i=n-1;i>dloc;i--)
        {
            d[j]=t[i];j++;
        }
        for(int i=0;i<n-1;i++)
        {	total=total+Math.abs(d[i]-d[i+1]);	}
        System.out.println("Total no. of distance of tracks= "+total);
        avgt=total/n;
        return avgt;
    }

    double SCAN(int t[],int n) {
        int[] d=new int[99999];
        double total = 0;
        int temp,max,dloc=0,h = 0;
        double avgt;
        h=t[n] = 0;
        n=n+1;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(t[i]>t[j])
                {
                    temp=t[i];t[i]=t[j];t[j]=temp;
                }
            }
        }
        max=t[n];
        for(int i=0;i<n;i++)
        {
            if(h==t[i]){dloc=i;break;}
        }
        int j=0;
        for(int i=dloc;i>=0;i--)
        {
            d[j]=t[i];j++;
        }
        for(int i=n-1;i>dloc;i--)
        {
            d[j]=t[i];j++;
        }
        for(int i=0;i<n-1;i++)
        {	total=total+Math.abs(d[i]-d[i+1]);	}
        System.out.println("Total no. of distance of tracks= "+total);
        avgt=total/n;
        return avgt;
}

    double CSCAN(int t[],int n) {
        int[] d=new int[99999];
        double total = 0;
        int temp,max,dloc=0,h = 0;
        double avgt;
        h=t[n] = 0;
        n=n+1;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(t[i]>t[j])
                {
                    temp=t[i];t[i]=t[j];t[j]=temp;
                }
            }
        }
        max=t[n];
        for(int i=0;i<n;i++)
        {
            if(h==t[i]){dloc=i;break;}
        }
        int j=0;
        for(int i=dloc;i>=0;i--)
        {
            d[j]=t[i];j++;
        }
        for(int i=n-1;i>dloc;i--)
        {
            d[j]=t[i];j++;
        }
        for(int i=0;i<n-1;i++)
        {	total=total+Math.abs(d[i]-d[i+1]);	}
        System.out.println("Total no. of distance of tracks= "+total);
        avgt=total/n;
        return avgt;
    }

}




