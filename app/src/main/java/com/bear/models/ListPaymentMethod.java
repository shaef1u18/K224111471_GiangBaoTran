package com.bear.models;

import java.util.ArrayList;

public class ListPaymentMethod {
    private ArrayList<PaymentMethod> paymentMethods;

    public ListPaymentMethod() {
        paymentMethods = new ArrayList<>();
    }

    public ArrayList<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public void add(PaymentMethod pm) {
        paymentMethods.add(pm);
    }

    // Optional: giữ lại dữ liệu mẫu nếu muốn test nhanh
    public void gen_payments_method() {
//        paymentMethods.add(new PaymentMethod(1, "Banking Account", "chuyển khoản ngân hàng"));
//        paymentMethods.add(new PaymentMethod(2, "MOMO", "thanh toán ví MOMO"));
//        paymentMethods.add(new PaymentMethod(3, "CASH", "thanh toán tiền mặt"));
//        paymentMethods.add(new PaymentMethod(4, "COD", "nhận hàng rồi thanh toán"));
    }
}
