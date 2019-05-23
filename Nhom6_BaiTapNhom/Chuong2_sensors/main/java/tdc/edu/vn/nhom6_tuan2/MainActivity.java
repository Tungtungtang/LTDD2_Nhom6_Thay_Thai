package tdc.edu.vn.nhom6_tuan2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnChoi, btnChoiLai;
    ImageView LaBai[] = new ImageView[3];
    TextView kq;
    //danh sách các lá đã rút
    ArrayList<LaBai> CacLaDaRut = new ArrayList<LaBai>();
    //danh sách các lá bài đã thêm vào
    ArrayList<LaBai> CacLaBai = new ArrayList<LaBai>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();
    }

    public void setControl(){
        btnChoi = (Button)findViewById(R.id.btnChoi);
        btnChoiLai = (Button)findViewById(R.id.btnChoiLai);
        kq = (TextView)findViewById(R.id.tv_Chao);
        LaBai[0] = (ImageView) findViewById(R.id.imageView01);
        LaBai[1] = (ImageView) findViewById(R.id.imageView02);
        LaBai[2] = (ImageView) findViewById(R.id.imageView03);
    }
    public void TaoBai(){
        //Thêm đối tượng LaBai vào arraylist của biến CacLaBai
        CacLaBai.add(new LaBai(1, "Ách", R.drawable.mot));
        CacLaBai.add(new LaBai(2, "Hai", R.drawable.hai));
        CacLaBai.add(new LaBai(3, "Ba", R.drawable.ba));
        CacLaBai.add(new LaBai(4, "Bốn", R.drawable.bon));
        CacLaBai.add(new LaBai(5, "Năm", R.drawable.nam));
        CacLaBai.add(new LaBai(6, "Sáu", R.drawable.sau));
        CacLaBai.add(new LaBai(7, "Bảy", R.drawable.bay));
        CacLaBai.add(new LaBai(8, "Tám", R.drawable.tam));
        CacLaBai.add(new LaBai(9, "Chín", R.drawable.chin));
        CacLaBai.add(new LaBai(10, "Mười", R.drawable.muoi));
        CacLaBai.add(new LaBai(11, "Bồi", R.drawable.boi));
        CacLaBai.add(new LaBai(12, "Đầm", R.drawable.dam));
        CacLaBai.add(new LaBai(13, "Già", R.drawable.gia));
    }

    public void setEvent(){
        //Nút chơi lại khi nhấn vào 3 lá sẽ ẩn đi bằng hình mặt sau của lá bài
        btnChoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaBai[0].setImageResource(R.drawable.matsau);//lá 1
                LaBai[1].setImageResource(R.drawable.matsau);//lá 2
                LaBai[2].setImageResource(R.drawable.matsau);//lá 3
                kq.setText("Chọn chơi bài để chia bài!");

                //xóa danh sách các lá bài đã rút
                CacLaDaRut.clear();
            }
        });

        //Khi nhấn nút sẽ ramdom ra ngẫu nhiên 3 lá bài
        btnChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tạo 3 lá bài trong 13 lá
                TaoBai();

                int SoNut = 0;

                //Xét trường hợp 3 Tây
                boolean BaTay = true;
                //Tên 3 lá rút ra được
                String TenCaLaBai = "Ban rút được:\n";

//                //Giới hạn số lần chơi lại
//                if (CacLaBai.size() < 3){
//                    kq.setText("Chọn chơi lại để chơi lại !");
//                    return;
//                }

                //Rút 3 lá bài ngẫu nhiên
                Random ran = new Random();//hàm random dùng xuất ngẫu nhiễn các dữ liệu sẵn có
                //Rút lá 1
                int la1 = ran.nextInt(CacLaBai.size() - 1);
                CacLaDaRut.add(CacLaBai.get(la1));
                CacLaBai.remove(la1);
                //Rút lá 2
                int la2 = ran.nextInt(CacLaBai.size() - 1);
                CacLaDaRut.add(CacLaBai.get(la2));
                CacLaBai.remove(la2);
                //Rút lá 3
                int la3 = ran.nextInt(CacLaBai.size() - 1);
                CacLaDaRut.add(CacLaBai.get(la3));
                CacLaBai.remove(la3);

                //Khai báo biến LaBai(int, String, int) = tenbien
                LaBai xetbai;
                int i;
                // Tính nút
                for ( i = 0; i < CacLaDaRut.size(); i++) {
                    xetbai = CacLaDaRut.get(i);
                    //Xét ba tây theo số nút
                    if (xetbai.SoNut <= 10){
                        BaTay = false;
                    }
                    //Nếu số nút mà lớn hơn 10 sẽ = 0 còn lại là lấy điểm bình thường
                    SoNut += xetbai.SoNut > 10 ? 0 : xetbai.SoNut;

                    LaBai[i].setImageResource(xetbai.Hinh);
                    //Tên các lá bài rút được
                    TenCaLaBai += "Lá bài số "+ (i+1)+ ": " + xetbai.Ten + "\n";

                }
                //Số nút chia 10 lấy dư là +=  lên 3 lần
                TenCaLaBai += "Ðược " + (SoNut % 10) + " nút !";

                //Nếu 3 tây != false (biến ở trên khai báo luôn == true) còn lại là xuất ra tên các lá bài
                TenCaLaBai = BaTay ? "Bạn rút được ba tây !" : TenCaLaBai;
                //Xuất ra tên các lá bài
                kq.setText(TenCaLaBai);

                CacLaDaRut.clear();
            }
        });
    }
}
