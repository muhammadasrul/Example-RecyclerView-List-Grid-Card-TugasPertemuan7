package com.asrul.tugaspertemuan7.Data;

import com.asrul.tugaspertemuan7.R;

import java.util.ArrayList;

public class DataCamera {
        private static String[] cameraNames = {
                "Canon Autoboy",
                "Konica Pop",
                "Minox",
                "Nikon F3",
                "Nikon F3/T",
                "Olympus-35 EC2",
                "Olympus Mju Zoom",
                "Olympus PEN EED",
                "Olympus XA 2",
                "Pentax",
                "Pentax Espio 105 Mi",
                "Pentax MX"
        };

        private static int[] cameraImages = {
                R.drawable.canon_autoboy2,
                R.drawable.konica_pop,
                R.drawable.minox,
                R.drawable.nikon_f3,
                R.drawable.nikon_f3t,
                R.drawable.olympus35ec2,
                R.drawable.olympus_mju_zoom,
                R.drawable.olympus_pen_eed,
                R.drawable.olympus_xa2,
                R.drawable.pentax,
                R.drawable.pentax_espio105mi,
                R.drawable.pentax_mx
        };

        private static String[] cameraPrice = {
                "Rp 1.500.000",
                "Rp 1.325.000",
                "Rp 950.000",
                "Rp 3.850.000",
                "Rp 1.500.000",
                "Rp 1.650.000",
                "Rp 1.500.000",
                "Rp 1.105.000",
                "Rp 3.250.000",
                "Rp 950.000",
                "Rp 1.575.000",
                "Rp 1.950.000"
        };

        public static ArrayList<Camera> getListData() {
            ArrayList<Camera> list = new ArrayList<>();
            for (int position = 0; position < cameraNames.length; position++) {
                Camera data = new Camera();
                data.setName(cameraNames[position]);
                data.setPhoto(cameraImages[position]);
                data.setPrice(cameraPrice[position]);
                list.add(data);
            }
            return list;
        }
}
