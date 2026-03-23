
package io.github.kartiksethi;

import io.github.kartiksethi.order.DigitalOrderProcessor;
import io.github.kartiksethi.order.TemplateOrderProcessor;
import io.github.kartiksethi.order.PhysicalOrderProcessor;
import io.github.kartiksethi.payment.PaypalPaymentProcessor;
import io.github.kartiksethi.payment.StripePaymentProcessor;
import io.github.kartiksethi.payment.PaymentProcessor;

        public class Main {
            public static void main(String[] args) {

                System.out.println("Physical Item + Stripe...");

                PaymentProcessor stripe = new StripePaymentProcessor();
                TemplateOrderProcessor physicalOrder = new PhysicalOrderProcessor(stripe);
                physicalOrder.processOrder("ORD-1001", 150.00);


                System.out.println("Digital Item + Paypal...");
                PaymentProcessor paypal = new PaypalPaymentProcessor();
                TemplateOrderProcessor digitalOrder = new DigitalOrderProcessor(paypal);
                digitalOrder.processOrder("DIG-9999", 100);
    }
}