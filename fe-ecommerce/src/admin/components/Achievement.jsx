import { Button, Card, CardContent, Typography, styled } from '@mui/material'
import React from 'react'
const trophyUrl = 'data:image/png;base64,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'
const TriangleImg = styled('img')({
    right: 0,
    bottom: 0,
    height: 170,
    position: 'absolute',
})

const TrophyImg = styled('img')({
    right: 36,
    bottom: 20,
    height: 98,
    position: 'absolute',
})
const Achievement = () => {
    return (
        <Card className='space-y-5' sx={{ position: "relative" }}>
            <CardContent>
                <Typography variant="h6" sx={{ letterSpacing: ".25px" }}>
                    Shop With Zosh
                </Typography>
                <Typography variant='body2'>Congratulations </Typography>
                <Typography variant='h5' sx={{ my: 3.1 }}> 420.8k </Typography>
                <Button size="small" variant='contained'>View Scales</Button>
                <TriangleImg src="" alt="" />
                <TrophyImg src={trophyUrl} alt="trophy" />
            </CardContent>
        </Card>
    )
}

export default Achievement