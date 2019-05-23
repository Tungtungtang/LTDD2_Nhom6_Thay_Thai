package tdc.edu.vn.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChonBan extends AppCompatActivity {
ImageButton ban1,ban2,ban3,ban4,ban5,ban6,ban7,ban8,ban9,ban10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ban);
        setControl();
        setEvent();
    }
    public void setControl()
    {

        ban1 =(ImageButton) findViewById(R.id.ban1);
        ban2 =(ImageButton) findViewById(R.id.ban2);
        ban3 =(ImageButton) findViewById(R.id.ban3);
        ban4 =(ImageButton) findViewById(R.id.ban4);
        ban5 =(ImageButton) findViewById(R.id.ban5);
        ban6 =(ImageButton) findViewById(R.id.ban6);
        ban7 =(ImageButton) findViewById(R.id.ban7);
        ban8 =(ImageButton) findViewById(R.id.ban8);
        ban9 =(ImageButton) findViewById(R.id.ban9);
        ban10 =(ImageButton) findViewById(R.id.ban10);
    }
    public void setEvent()
    {
        ban1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });
        ban2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });
        ban3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });
        ban4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });
        ban5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });
        ban6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });
        ban7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });
        ban8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });
        ban9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });
        ban10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });

    }
}
