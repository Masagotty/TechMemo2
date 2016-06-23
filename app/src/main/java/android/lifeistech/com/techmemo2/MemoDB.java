package android.lifeistech.com.techmemo2;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Gotty on 6/22/16.
 */
@Table(name = "memo_table")
public class MemoDB extends Model {
    @Column(name = "title")
    public String title;

    @Column(name = "memo")
    public String memo;

    @Column(name = "date")
    public String date;

    @Override
    public String toString(){
        return title;
    }
}
