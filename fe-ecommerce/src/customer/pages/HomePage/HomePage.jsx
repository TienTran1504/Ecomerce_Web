import React from 'react'
import { mens_kurta } from '../../../Data/Men/mens_kurta'
import HomeCarousel from '../../components/HomeCarousel/HomeCarousel'
import HomeSectionCarousel from '../../components/HomeSectionCarousel/HomeSectionCarosel'

const HomePage = () => {
    return (
        <div>
            <HomeCarousel />

            <div className='py-20 space-y-10 flex flex-col justify-center px-5 lg:px-10'>
                <HomeSectionCarousel data={mens_kurta} sectionName={"Men's Kurta"} />
                <HomeSectionCarousel data={mens_kurta} sectionName={"Men's Shoes"} />
                <HomeSectionCarousel data={mens_kurta} sectionName={"Men's Shirt"} />
                <HomeSectionCarousel data={mens_kurta} sectionName={"Women's Saree"} />
                <HomeSectionCarousel data={mens_kurta} sectionName={"Women's Dress"} />

            </div>

        </div>
    )
}

export default HomePage