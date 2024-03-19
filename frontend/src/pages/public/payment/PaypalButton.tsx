import React from 'react'
import { PayPalButtons } from '@paypal/react-paypal-js'
import toast from 'react-hot-toast';

interface PayPalButtonInterface {
    totalValue: string;
    invoice: string;
}

const PaypalButton: React.FC<PayPalButtonInterface> = (props) => {
    const createOrderHandler = async (data: any, actions: any) => {
        try {
            const order = await actions.order.create({
                purchase_units: [
                    {
                        description: props.invoice,
                        amount: {
                            currency_code: 'USD',
                            value: props.totalValue,
                        },
                    },
                ],
                intent: 'CAPTURE'
            });
            console.log("Orden creada:", order);
            console.log("Data creada:", data);
            return order;
        } catch (error: any) {
            console.log("Error al crear la orden:", error);
            toast.error("Hobo un error, intentalo de nuevo");
        }
    };

    const onErrorHandler = async (err: any) => {
        console.log("Error en la transacción:", err);
    };

    const onCancelHandler = async (data: any) => {
        console.log("Transacción cancelada:", data);
    };

    const onApprove = async (data: any, actions: any) => {
        try {
            const order = await actions.order?.capture();
            console.log("order", order);
            console.log("data", data);
            toast.success("Pago realizado con exito")
        } catch (error: any) {
            console.error("Error al capturar el pago:", error);
            toast.error("Error al capturar el pago: " + error.message);
        }
    };

    return (
        <div className=' outline-none ring-0 focus:ring-0 focus:outline-none'>
            <PayPalButtons
                createOrder={createOrderHandler}
                onApprove={onApprove}
                onError={onErrorHandler}
                onCancel={onCancelHandler}

            />
        </div>
    )
}

export default PaypalButton
