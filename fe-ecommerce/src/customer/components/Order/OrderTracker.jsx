import { Step, StepLabel, Stepper } from '@mui/material'
import React from 'react'

const steps = [
    "Placed",
    "Order Confirmed",
    'Shipped',
    "Out For Delivery",
    "Delivered",
]
const OrderTracker = ({ activeStep }) => {
    return (
        <div className='w-full'>
            <Stepper activeStep={activeStep} alternativeLabel>
                {
                    steps.map((label, index) => <Step>
                        <StepLabel key={index} sx={{ color: "#9155FD", fontSize: "44px" }}>{label}</StepLabel>
                    </Step>
                    )

                }
            </Stepper>
        </div>
    )
}

export default OrderTracker